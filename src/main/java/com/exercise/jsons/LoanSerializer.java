package com.exercise.jsons;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public  class LoanSerializer extends JsonSerializer<LoanTrade> {

        @Override
        public void serialize(LoanTrade loanTrade, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("order-no", loanTrade.getOrderNo());
            jsonGenerator.writeStringField("mch-order-no", loanTrade.getMchOrderNo());
            jsonGenerator.writeEndObject();
        }
    }