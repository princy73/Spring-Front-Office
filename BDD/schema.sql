CREATE TABLE Admin(
    Id SERIAL PRIMARY KEY ,
    Nom VARCHAR(255),
    email VARCHAR(255),
    mdp VARCHAR(255)
);

CREATE TABLE Clients(
    Id SERIAL PRIMARY KEY ,
    NomClients VARCHAR(255),
    PrenomClients VARCHAR(255),
    mdpClients VARCHAR(255),
    emailClients VARCHAR(255),
    budget float,
    demande int
);

CREATE TABLE Categories(
    Id SERIAL PRIMARY KEY ,
    nomCategor VARCHAR(255),
    dureEnchere int,
    pourcentage int
);

CREATE TABLE TypeProduit(
    Id SERIAL PRIMARY KEY ,
    nomTypeP VARCHAR(255),
    idCategories int
);

CREATE TABLE EnchereProduit(
    Idclient int  ,
    IdProduit int,
    Offre float,
    dateT date,
    statut default 0
);

CREATE TABLE Produit(
    Id SERIAL PRIMARY KEY ,
    IDTypeProduit int,
    descriptions VARCHAR(255),
    image text,
    prixminimum float,
    statut int 
);

ALTER TABLE EnchereProduit ADD FOREIGN KEY (Idclient) REFERENCES Clients(Id);
ALTER TABLE EnchereProduit ADD FOREIGN KEY (IdProduit) REFERENCES Produit(Id);
ALTER TABLE Produit ADD FOREIGN KEY (IdTypeProduit) REFERENCES TypeProduit(Id);
ALTER TABLE TypeProduit ADD FOREIGN KEY (IdCategories) REFERENCES Categories(Id);