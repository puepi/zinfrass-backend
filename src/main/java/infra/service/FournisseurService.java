package infra.service;

import infra.dto.Mapper;
import infra.dto.request.FournisseurRequestDto;
import infra.dto.response.FournisseurResponseDto;
import infra.model.Fournisseur;
import infra.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

@Service
public class FournisseurService implements IFournisseurService{
    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurResponseDto addFournisseur(FournisseurRequestDto request) {
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setAdresse(request.getAdresse());
        fournisseur.setNIU(request.getNIU());
        fournisseur.setContact(request.getContact());
        fournisseur.setNom(request.getNom());
        fournisseur.setEmail(request.getEmail());
        fournisseur.setType(request.getType());
        fournisseur.setTechniciens(request.getTechniciens());
        fournisseur.setRepresentant(request.getRepresentant());
        return Mapper.fournisseurToFournisseurResponseDto(fournisseurRepository.save(fournisseur));
    }
}
