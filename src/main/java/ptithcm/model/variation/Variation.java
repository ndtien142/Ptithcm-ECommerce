package ptithcm.model.variation;

import java.util.Collection;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Variation")
public class Variation {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "variation", fetch = FetchType.EAGER)
	private Collection<VariationOption> variationOptions;

	public Variation() {
		super();
	}

	public Variation(Integer id, Category category, String name, Collection<VariationOption> variationOptions) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.variationOptions = variationOptions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<VariationOption> getVariationOptions() {
		return variationOptions;
	}

	public void setVariationOptions(Collection<VariationOption> variationOptions) {
		this.variationOptions = variationOptions;
	}

}
