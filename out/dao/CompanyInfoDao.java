import com.daishuaiqing.chenhuan.domain.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyInfoDao extends JpaRepository<CompanyInfo, Long>,JpaSpecificationExecutor<CompanyInfo> {
 }