package dz.djezzydevs.networkdep.business.dao;

import dz.djezzydevs.networkdep.business.data.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteDao extends JpaRepository<Site,String> {
}
