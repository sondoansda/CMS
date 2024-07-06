package fa.training.service;

import fa.training.entity.Content;
import fa.training.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContentService {
    void save(Content content);
    void delete(Content content);
    Page<Content> findAll(Pageable pageable);
}

