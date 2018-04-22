package demo.service.impl;

import demo.domain.InfoAnalysis;
import demo.domain.InformationRepository;
import demo.service.InfoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InfoAnalysisServiceImpl implements InfoAnalysisService{

    private InformationRepository informationRepository;

    @Autowired    
    public InfoAnalysisServiceImpl(InformationRepository informationRepository){
        this.informationRepository = informationRepository;

    }

    @Override
    public List<InfoAnalysis> saveRunningInformation(List<InfoAnalysis> runningInformation) {
        return informationRepository.save(runningInformation);
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        informationRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<InfoAnalysis> findAllByOrderByHeartRateDesc(Pageable pageable) {
        return informationRepository.findAllByOrderByHeartRateDesc(pageable);
    }


    @Override
    public Page<InfoAnalysis> findByUserId(Long userId, Pageable pageable) {
        return informationRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<InfoAnalysis> findByRunningId(String runningId, Pageable pageable) {
        return informationRepository.findByRunningId(runningId, pageable);
    }
}