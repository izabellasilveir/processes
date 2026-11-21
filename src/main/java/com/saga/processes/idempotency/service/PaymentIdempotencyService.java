package com.saga.processes.idempotency.service;

import java.time.Duration;
import java.util.UUID;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.saga.processes.idempotency.dto.PaymentRequest;

@Service 
public class PaymentIdempotencyService {

    private StringRedisTemplate redisTemplate;
    
    public PaymentIdempotencyService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String processPayment(PaymentRequest paymentRequest) {
        String key = "payment:" + paymentRequest.getIdempotencyKey();

        //verifica se a transacao ja foi processada
        String existingPayment = redisTemplate.opsForValue().get(key);

        if(existingPayment != null) {
            return "Transacao ja foi processada: " + existingPayment;
        }

        // tenta reservar a chave automaticamente
        Boolean reserved = redisTemplate.opsForValue().setIfAbsent(key, "PROCESSING", Duration.ofSeconds(5));
        if (!Boolean.TRUE.equals(reserved)) {
            return "Transacao ja esta sendo processada";
        }

        try {
            // simulacao do processamento do pagamento
            String transactionId = UUID.randomUUID().toString();

            // atualiza o status
            redisTemplate.opsForValue().set(key, transactionId, Duration.ofSeconds(5));
            
            return "Pagamento aprovado: " + transactionId;
        } catch (Exception e) {
            redisTemplate.delete(key);
            throw new RuntimeException("Erro ao processar pagamento", e);
        }
    }
}
