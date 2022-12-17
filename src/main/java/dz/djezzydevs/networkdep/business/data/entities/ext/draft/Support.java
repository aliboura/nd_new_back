package dz.djezzydevs.networkdep.business.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Support {
    @Id
    @GeneratedValue
    private Long id;
    private String forme;
    private String type;
    private String hauter;
    private String fournisseur;
    private String capacitePylone;
    private String sectionHorizontal;
}
