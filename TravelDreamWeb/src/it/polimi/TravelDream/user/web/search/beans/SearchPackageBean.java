package it.polimi.TravelDream.user.web.search.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import it.polimi.TravelDream.ejb.packageManagement.PackageMgr;
import it.polimi.TravelDream.ejb.packageManagement.dto.PackageDTO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="searchPackageBean")
@SessionScoped
public class SearchPackageBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PackageMgr packageMgr;    
	
	private int idPackage;
	
	private PackageDTO selectedPackage; 
		
	public SearchPackageBean(){
		System.out.println("costruttore - id="+idPackage);
	}
	
//	@PostConstruct
//	public void afterCunstruct(){
//		System.out.println("post costruttore - id="+idPackage);
//	}
	
	public void handleSearchById(){
		System.out.println("HANDLE - ID:"+idPackage);
		selectCustom();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("customPackageDetail.xhtml");
		} catch (IOException e) {
			e.printStackTrace();;
		}
		return;
	}
	
	public void choose(int idPackage){
		selectedPackage = packageMgr.getselectedPackageDTO(idPackage);
		return;
	}
	
	public void selectCustom(){
		System.out.println("selectCustom - ID= "+idPackage);
		selectedPackage = packageMgr.getCustomPackageDTO(idPackage);
	}
	
	public List<PackageDTO> getAllPackages() {
		return packageMgr.getAllPackagesDTO();
	}	
	
	public int getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public PackageDTO getSelectedPackage() {
		return selectedPackage;
	}

	public void setSelectedPackage(PackageDTO selectedPackage) {
		this.selectedPackage = selectedPackage;
	}
  
}