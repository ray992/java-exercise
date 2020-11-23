package com.exercise.jsons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @ClassName LoanDeserialize
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/11/23 10:34 下午
 * @Version 1.0
 **/
public class LoanDeserialize extends JsonDeserializer<LoanTrade> {
    @Override
    public LoanTrade deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String orderNo = node.get("order-no").asText();
        LoanTrade loanTrade = new LoanTrade();
        loanTrade.setOrderNo(orderNo);
        return loanTrade;
    }
}
