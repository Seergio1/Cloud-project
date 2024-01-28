package com.example.ventevoiture01.Services;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ventevoiture01.Models.Vente;
import com.example.ventevoiture01.Models.Employer;
import com.example.ventevoiture01.Models.Vente;
import com.example.ventevoiture01.Repository.VenteJPA;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    private VenteJPA VenteRepository;

    public List<Vente> getAllVentes() {
        return VenteRepository.findAll();
    }

    public Optional<Vente> getVenteById(int id) {
        return VenteRepository.findById(id);
    }

    public Vente createVente(Vente Vente) {
        return VenteRepository.save(Vente);
    }

    public Vente updateVente(int id, Vente updatedVente) {
        if (VenteRepository.existsById(id)) {
            updatedVente.setId(id);
            return VenteRepository.save(updatedVente);
        } else {
            // Gérer le cas où le Vente avec l'ID spécifié n'est pas trouvé
            return null;
        }
    }

    public void deleteVente(int id) {
        VenteRepository.deleteById(id);
    }

    public ArrayList<Vente> getVenteByUtilisateur(Employer employer) {
        ArrayList<Vente> result = new ArrayList<Vente>();
        List<Vente> annonces = VenteRepository.findAll();
        for (Vente ann : annonces) {
            if (ann.getVendeur().getId() == employer.getId()) {
                result.add(ann);
            }
        }
        return result;
    }
}