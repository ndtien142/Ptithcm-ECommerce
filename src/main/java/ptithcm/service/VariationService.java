package ptithcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.variation.VariationDao;
import ptithcm.model.product.Variation;

@Service
@Transactional
public class VariationService {
	@Autowired
	VariationDao variationDao;

	public void insertVariation(Variation variation) {
		variationDao.insert(variation);
	}

	public List<Variation> getAllVariations() {
		return variationDao.getAllVariations();
	}

	public List<Variation> getListPaginatedVariations(int firstResult, int maxResults) {
		return variationDao.listPaginatedProductVariation(firstResult, maxResults);
	}

	public void deleteVariationById(int variationId) {
		variationDao.deleteById(variationId);
	}

	public Variation getVariationById(int variationId) {
		return variationDao.getVariationById(variationId);
	}

	public void updateVariation(Variation variation) {
		variationDao.updateById(variation);
	}
}
