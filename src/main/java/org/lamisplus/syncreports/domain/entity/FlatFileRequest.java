package org.lamisplus.syncreports.domain.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class FlatFileRequest
{
    private Long ipCode;
    @NotNull(message = "fy cannot be empty/null")
    private Long fy;
    @NotBlank(message = "quarter cannot be empty/null")
    private String quarter;
    private List<Long> dataElements;
    @NotBlank(message = "Facility Ids cannot be empty/null")
    private List<String> facilityIds;
    @NotBlank(message = "IPName cannot be empty/null")
    private String IPName;
}
