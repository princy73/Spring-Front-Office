Create or replace VIEW v_categplusvendue as
select  count(tp.idcategories) as nbvente, nomcategor from produit p 
join typeproduit tp on tp.id = p.idtypeproduit  join categories c on c.id=tp.idcategories
where p.statut >0 group by tp.idcategories , c.nomcategor order by nbvente desc;

select * from v_categplusvendue ;

CREATE OR REPLACE VIEW v_categtypeproduit as
select c.id,c.nomcategor,tp.nomTypeP from TypeProduit tp join categories c on c.id=tp.idCategories;

CREATE or replace view v_categplusdargent as
select 
 c.nomcategor as categorie, sum(offre) as argentgenere
from enchereproduit e  
join produit p on p.id = e.idproduit 
join typeproduit t on t.id = p.idtypeproduit 
join categories c on c.id = t.idcategories 
where e.statut  >0 group by  nomcategor order by argentgenere desc ;

create or replace v_mesencheres
select idclient, offre, datet  ,idproduit, t.nomtypep
from enchereproduit e 
join produit p on p.id = e.idproduit 
join typeproduit t on t.id = p.idtypeproduit 
join categories c on c.id = t.idcategories 
where e.statut = 0 ;