package com.example.inicial1.entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Localidad extends Base{
    private String denominacion;
}