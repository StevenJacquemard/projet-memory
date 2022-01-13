package fr.ensma.a3.ia.carnetadressesdao.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.exceptions.ExistingElementException;
import fr.ensma.a3.ia.carnetadressesdao.dao.exceptions.MissingElementException;

/**
 * DAO de l'entity AdresseEntity.
 * @author michaelrichard
 *
 */
public class AdressePoiDAO extends AbstractPoiDAO<AdresseEntity>{

	private static Logger LOGGER = Logger.getLogger(AdressePoiDAO.class.getName());
	
	@Override
	public Optional<AdresseEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Adresses");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		AdresseEntity adr = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			adr = new AdresseEntity();
			if (id == (int)ligne.getCell(0).getNumericCellValue()) {
				adr.setIdAdr((int)ligne.getCell(0).getNumericCellValue());
				adr.setNumRue((int)ligne.getCell(1).getNumericCellValue());
				adr.setNomRue(ligne.getCell(2).getStringCellValue());
				adr.setCodePostal((int)ligne.getCell(3).getNumericCellValue());
				adr.setNomVille(ligne.getCell(4).getStringCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			closeBase(bdd);
			return Optional.of(adr);
		}
		closeBase(bdd);
		return Optional.empty();		
	}
	
	@Override
	public Optional<AdresseEntity> getByValue(AdresseEntity elem) {
		List<AdresseEntity> listtemp = getAll();
		for (AdresseEntity ad : listtemp) {
			if (ad.equals(elem)) {
				return Optional.of(ad);
			}
		}
		return Optional.empty();
	}
	

	@Override
	public List<AdresseEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Adresses");
		ArrayList<AdresseEntity> listeadr = new ArrayList<AdresseEntity>();
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row ligne = iterator.next();
			AdresseEntity adr = new AdresseEntity();
			Iterator<Cell> cellIterator = ligne.iterator();
			Cell cellule = cellIterator.next();
			adr.setIdAdr((int)cellule.getNumericCellValue());
			adr.setNumRue((int)ligne.getCell(1).getNumericCellValue());
			adr.setNomRue(ligne.getCell(2).getStringCellValue());
			adr.setCodePostal((int)ligne.getCell(3).getNumericCellValue());
			adr.setNomVille(ligne.getCell(4).getStringCellValue());
			listeadr.add(adr);
		}
		closeBase(bdd);
		return listeadr;
	}

	@Override
	public void create(AdresseEntity elem) {
		if (getByValue(elem).isEmpty()) {
			XSSFWorkbook bdd = openBase();
			Sheet tableadr = bdd.getSheet("Adresses");
			int lrow = tableadr.getLastRowNum();
			int lid = (int) tableadr.getRow(lrow).getCell(0).getNumericCellValue();
			elem.setIdAdr(lid + 1);
			Row ligne = tableadr.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getIdAdr());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getNumRue());
			cell = ligne.createCell(2);
			cell.setCellValue(elem.getNomRue());
			cell = ligne.createCell(3);
			cell.setCellValue(elem.getCodePostal());
			cell = ligne.createCell(4);
			cell.setCellValue(elem.getNomVille());
			writeBase(bdd);
			closeBase(bdd);
		} else {
			LOGGER.log(Level.INFO,"Element Deja dans la base ...");
			throw new ExistingElementException();
		}
	}

	@Override
	public void update(AdresseEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Adresses");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdAdr() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getNumRue());
				ligne.getCell(2).setCellValue(elem.getNomRue());
				ligne.getCell(3).setCellValue(elem.getCodePostal());
				ligne.getCell(4).setCellValue(elem.getNomVille());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			LOGGER.log(Level.INFO,"Element absent de la base ...");
			throw new MissingElementException();
		}
		closeBase(bdd);
	}

	@Override
	public void delete(AdresseEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Adresses");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdAdr() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				removeRow(tableadr, ligne.getRowNum());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			LOGGER.log(Level.INFO,"Element absent de la base ...");
			throw new MissingElementException();
		}
		closeBase(bdd);
	}	
}
