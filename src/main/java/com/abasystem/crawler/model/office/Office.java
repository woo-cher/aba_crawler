package com.abasystem.crawler.model.office;

import com.abasystem.crawler.mapper.ModelMapper;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Office extends ModelMapper {
    private String jibunAddress;
    private String extraAddress;
    private String name;
    private String representative;
    private String tel;
    private String mTel;
}
