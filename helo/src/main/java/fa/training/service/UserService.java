package fa.training.service;

import fa.training.entity.User;

public interface UserService {
    User save(User user);
    void delete(User user);
}

