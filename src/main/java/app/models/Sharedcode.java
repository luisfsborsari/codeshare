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
	
}
