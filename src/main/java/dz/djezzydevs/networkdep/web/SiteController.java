package dz.djezzydevs.networkdep.web;

import dz.djezzydevs.networkdep.business.data.dto.CandidateOutputDto;
import dz.djezzydevs.networkdep.business.data.dto.SiteInputDto;
import dz.djezzydevs.networkdep.business.data.dto.SiteOutputDto;
import dz.djezzydevs.networkdep.business.data.entities.Candidate;
import dz.djezzydevs.networkdep.business.data.entities.Site;
import dz.djezzydevs.networkdep.business.services.CandidateService;
import dz.djezzydevs.networkdep.business.services.SiteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/site")

public class SiteController {

    @Autowired
    SiteService siteService;

    @Autowired
    CandidateService candidateService;

    ModelMapper modelMapper = new ModelMapper();


    @PostMapping(path = "/new",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    public SiteInputDto add(@RequestBody SiteInputDto siteInputDto) throws Exception {

       ModelMapper modelMapper = new ModelMapper();
       Site site = modelMapper.map(siteInputDto, Site.class);

       SiteInputDto siteCreated= siteService.add(site);
        return siteCreated;
     //   return site;

    }

    @GetMapping(path="/")
    public Site getSite()  {
       Site st= new Site();
        st.setCode("ppt");
        return st;
    }

    @GetMapping("/cand/{site}")
    public CandidateOutputDto getCurrentCandidate(
            @PathVariable(name="site") String codeSite,
            @RequestParam(value = "idcandidate", required = false) Long idCondidate) {

        Candidate cand=new Candidate();
        if (idCondidate ==null) {
            cand= siteService.getActiveCandidate(codeSite);
        }else {
            cand=candidateService.find(idCondidate);
        }
        //   Candidate candidate = candidateService.find(idCondidate);
        ModelMapper modelMapper = new ModelMapper();
        CandidateOutputDto candDto = modelMapper.map(cand, CandidateOutputDto.class);
        return candDto;
    }


    @GetMapping("candlist/{site}")
    public List<CandidateOutputDto> getListCandidate(
            @PathVariable(name="site") String codeSite) {

        List<Candidate> candidateList=siteService.find(codeSite).getCondidates();
        //   Candidate candidate = candidateService.find(idCondidate);
      //  ModelMapper modelMapper = new ModelMapper();
       // List<CandidateOutputDto> candDtoList = new ArrayList<CandidateOutputDto>();

        List<CandidateOutputDto> entityToDtos = this.modelMapper.map(candidateList, new TypeToken<List<CandidateOutputDto>>(){}.getType());



        return entityToDtos;
    }

    @GetMapping("{site}")
    public SiteOutputDto getSite(@PathVariable(name="site") String codeSite) {

        Site site=siteService.find(codeSite);

        SiteOutputDto siteDto = this.modelMapper.map(site, SiteOutputDto.class);

        return siteDto;
    }



}
