package com.irshita.patel.model;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ErrorDetails {

    private Date timestamps;

    private String msg;

    private String path;
}
