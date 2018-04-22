package demo.service;

import demo.domain.InfoAnalysis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InfoAnalysisService {

    List<InfoAnalysis> saveRunningInformation(List<InfoAnalysis> runningInformation);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<InfoAnalysis> findAllByOrderByHeartRateDesc(Pageable pageable);

    Page<InfoAnalysis> findByUserId(Long userId, Pageable pageable);

    Page<InfoAnalysis> findByRunningId(String runningId, Pageable pageable);
}