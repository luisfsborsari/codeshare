package app.models;

@javax.persistence.Entity
public class Sharedcode extends Entity {
	
	private String nome;
	private String tags;
	private String linguagem;
	private String codigo;
	
	public Sharedcode(String nome, String tags, String linguagem, String codigo) {
		super();
		this.nome = nome;
		this.tags = tags;
		this.linguagem = linguagem;
		this.codigo = codigo;
	}

	public Sharedcode(){
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getTags() {
		return tags;
	}
	
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	public String getLinguagem() {
		return linguagem;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Sharedcode [nome=" + nome + ", tags=" + tags + ", linguagem="
				+ linguagem + ", codigo=" + codigo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((linguagem == null) ? 0 : linguagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sharedcode other = (Sharedcode) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (linguagem == null) {
			if (other.linguagem != null)
				return false;
		} else if (!linguagem.equals(other.linguagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
	
	
}
