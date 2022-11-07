package dz.djezzydevs.networkdep.web;

import dz.djezzydevs.networkdep.business.dao.WilayaDao;
import dz.djezzydevs.networkdep.business.data.entities.Site;
import dz.djezzydevs.networkdep.business.data.entities.Wilaya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/helper")
public class HelperController {
    @Autowired
    WilayaDao wilayaRepo;

    @GetMapping(path="/getwilaya")
    public List<Wilaya> getWilaya()  {
        return wilayaRepo.findAll();
    }
}
