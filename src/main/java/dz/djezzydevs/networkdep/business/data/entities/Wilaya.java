package dz.djezzydevs.networkdep.business.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Wilaya {
    @Id
    private Integer id;
    private String name;
    private String region;

}
