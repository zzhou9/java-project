package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface InformationRepository extends JpaRepository<InfoAnalysis, Long>{
   
    Page<InfoAnalysis> findByUserId(@Param("userId") Long userId, Pageable pageable);

    Page<InfoAnalysis> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    Page<InfoAnalysis> findAllByOrderByHeartRateDesc(Pageable pageable);

    void deleteByRunningId(@Param("runningId") String runningId);
}