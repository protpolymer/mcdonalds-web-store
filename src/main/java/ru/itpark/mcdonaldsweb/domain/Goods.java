package ru.itpark.mcdonaldsweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String name;
    private String description;
    private String price;
    private String imageLink;
    private String imageLinkView;
}
