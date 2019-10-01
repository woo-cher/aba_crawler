package com.abasystem.crawler.Model.PeterPan;

import com.abasystem.crawler.Mapper.ModelMapper;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class IrregularProperty implements ModelMapper {
    private int id;
    private String title;
    private String description;
    private String date;
    private String url;

    public IrregularProperty(String title, String description, String date, String url) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nIrregularProperty{" +
                "\n\t title='" + title + '\'' +
                ",\n\t description='" + description + '\'' +
                ",\n\t date='" + date + '\'' +
                ",\n\t url='" + url + '\'' +
                '}';
    }
}