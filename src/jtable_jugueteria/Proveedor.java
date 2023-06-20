package jtable_jugueteria;

public class Proveedor 
{
	int id_prov; //PK / 122
	String nom_prov; // Lego,JulioCepeda
	String tel_prov; // 81 2203 2334
	String mail_prov; // lego_prov@lego.com
	
	public Proveedor(int id_prov, String nom_prov, String tel_prov, String mail_prov) 
	{
		this.id_prov = id_prov;
		this.nom_prov = nom_prov;
		this.tel_prov = tel_prov;
		this.mail_prov = mail_prov;
	}
	public String getNom_prov() 
	{
		return nom_prov;
	}
	public void setNom_prov(String nom_prov) 
	{
		this.nom_prov = nom_prov;
	}
	public String getTel_prov() 
	{
		return tel_prov;
	}
	public void setTel_prov(String tel_prov)
	{
		this.tel_prov = tel_prov;
	}
	public String getMail_prov() 
	{
		return mail_prov;
	}
	public void setMail_prov(String mail_prov) 
	{
		this.mail_prov = mail_prov;
	}
	public int getId_prov() 
	{
		return id_prov;
	}
	@Override
	public String toString() {
		return getId_prov()+","+getNom_prov()+","+getTel_prov()+","+getMail_prov();
	}
}