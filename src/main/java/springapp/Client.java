package springapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springapp.dba.DBAConnection;

public class Client {
    Integer idClient;
    String nom;
    String prenom;
    String mdp;
    String email;
    float budget;
    int demande;


    public Client() {
    }

    public Client(Integer idClient, String nom, String prenom, String mdp, String email, float budget, int demande) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
        this.budget = budget;
        this.demande = demande;
    }

    public Integer getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getBudget() {
        return this.budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public int getDemande() {
        return this.demande;
    }

    public void setDemande(int demande) {
        this.demande = demande;
    }

    public Client idClient(int idClient) {
        setIdClient(idClient);
        return this;
    }

    public Client nom(String nom) {
        setNom(nom);
        return this;
    }

    public Client prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public Client mdp(String mdp) {
        setMdp(mdp);
        return this;
    }

    public Client email(String email) {
        setEmail(email);
        return this;
    }

    public Client budget(float budget) {
        setBudget(budget);
        return this;
    }

    public Client demande(int demande) {
        setDemande(demande);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " idClient='" + getIdClient() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", mdp='" + getMdp() + "'" +
            ", email='" + getEmail() + "'" +
            ", budget='" + getBudget() + "'" +
            ", demande='" + getDemande() + "'" +
            "}";
    }

    public int Login() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select id from Clients where emailclients = ? and mdpclients = ?");

            ps.setString(1, this.getEmail());
            ps.setString(2, this.getMdp());
            rs = ps.executeQuery();

            while (rs.next()) {
                setIdClient(rs.getInt("id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            rs.close();
            ps.close();
            con.close();
        }if(getIdClient()!=null){
            return 1;
        }return 0;

    }
}
