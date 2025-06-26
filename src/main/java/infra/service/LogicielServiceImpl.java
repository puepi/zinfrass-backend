package infra.service;

import infra.model.Logiciel;
import infra.repository.LogicielRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogicielServiceImpl implements LogicielService {
    public final LogicielRepository logicielRepository;

    @Override
    public Logiciel addLogiciel(Logiciel logiciel) {
        return logicielRepository.save(logiciel);
    }
}
