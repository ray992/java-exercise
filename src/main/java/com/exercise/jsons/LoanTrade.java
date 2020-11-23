package com.exercise.jsons;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = LoanSerializer.class)
@JsonDeserialize(using = LoanDeserialize.class)
// @JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class) //指定命名策略
public  class LoanTrade implements Serializable {

    private String orderNo;

    private String mchOrderNo;

    private String channelOrderNo;
}