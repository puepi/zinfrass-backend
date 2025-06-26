package infra.service;

import infra.model.Logiciel;
import org.springframework.stereotype.Service;

@Service
public interface LogicielService {
    Logiciel addLogiciel(Logiciel logiciel);
}
