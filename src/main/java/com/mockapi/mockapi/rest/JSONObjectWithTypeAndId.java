package com.mockapi.mockapi.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JSONObjectWithTypeAndId
{
    private Long id;
    private DataType dataType;
    private JSONObject jsonObject;
}
