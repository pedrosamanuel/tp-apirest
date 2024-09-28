package com.example.inicial1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Audited(targetAuditMode = NOT_AUDITED)
public class Libro extends Base{
    private String titulo;
    private int paginas;
    private Date fecha;
    private String genero;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();
}