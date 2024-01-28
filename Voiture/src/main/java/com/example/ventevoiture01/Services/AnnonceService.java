package com.example.ventevoiture01.Services;

import com.example.ventevoiture01.Models.Annonce;
import com.example.ventevoiture01.Models.Annonce_Favoris;
import com.example.ventevoiture01.Models.Employer;
import com.example.ventevoiture01.Models.MeilleureAnnonce;
import com.example.ventevoiture01.Repository.AnnonceFavorisJPA;
import com.example.ventevoiture01.Repository.AnnonceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceJPA annonceRepository;

    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    public Optional<Annonce> getAnnonceById(int id) {
        return annonceRepository.findById(id);
    }

    public Annonce createAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public Annonce updateAnnonce(int id, Annonce updatedAnnonce) {
        if (annonceRepository.existsById(id)) {
            updatedAnnonce.setId_annonce(id);
            return annonceRepository.save(updatedAnnonce);
        } else {
            // Gérer le cas où l'annonce avec l'ID spécifié n'est pas trouvée
            return null;
        }
    }

    public void deleteAnnonce(int id) {
        annonceRepository.deleteById(id);
    }

    public List<Annonce> getAnnonceByUtilisateur(Employer employer) {
        List<Annonce> result = new ArrayList<Annonce>();
        List<Annonce> annonces = annonceRepository.findAll();
        for (Annonce ann : annonces) {
            if (ann.getEmployer().getId() == employer.getId()) {
                result.add(ann);
            }
        }
        return result;
    }

    public List<Annonce> getAnnonceByStatus(String employer) {
        List<Annonce> result = new ArrayList<Annonce>();
        List<Annonce> annonces = annonceRepository.findAll();
        for (Annonce ann : annonces) {
            if (ann.getStatus_voiture().compareTo(employer) == 0) {
                result.add(ann);
            }
        }
        return result;
    }

    public List<Annonce> getAnnonceByEtat(String employer) {
        List<Annonce> result = new ArrayList<Annonce>();
        List<Annonce> annonces = annonceRepository.findAll();
        for (Annonce ann : annonces) {
            if (ann.getEtat_annonce().compareTo(employer) == 0) {
                result.add(ann);
            }
        }
        return result;
    }

    @Autowired
    AnnonceFavorisJPA annonceFavorisJPA;

    public List<Annonce_Favoris> getAnnonceFavorisByUtilisateur(Employer employer) {
        List<Annonce_Favoris> result = new ArrayList<Annonce_Favoris>();
        List<Annonce_Favoris> annonces = annonceFavorisJPA.findAll();
        for (Annonce_Favoris ann : annonces) {
            if (ann.getEmployer().getId() == employer.getId()) {
                result.add(ann);
            }
        }
        return result;
    }

    public List<MeilleureAnnonce> countFavorisByAnnonce() {
        return annonceFavorisJPA.countFavorisByAnnonce();
    }
    
    public Annonce_Favoris createAnnonceFavoris(Annonce annonce, Employer employer) {
        Annonce_Favoris annonceFavoris = new Annonce_Favoris(annonce, employer);
        return annonceFavorisJPA.save(annonceFavoris);
    }

    public Annonce updateStatusVoiture(int id, String statusVoiture) {
        Optional<Annonce> existingAnnonce = annonceRepository.findById(id);

        if (existingAnnonce.isPresent()) {
            Annonce annonce = existingAnnonce.get();
            annonce.setStatus_voiture(statusVoiture);
            return annonceRepository.save(annonce);
        } else {
            return null;
        }
    }

    /*
     * public Annonce valider(int id) {
     * Optional<Annonce> existingAnnonce = annonceRepository.findById(id);
     * 
     * if (existingAnnonce.isPresent()) {
     * Annonce annonce = existingAnnonce.get();
     * annonce.setStatus_voiture(statusVoiture);
     * return annonceRepository.save(annonce);
     * } else {
     * return null;
     * }
     * }
     */
}
