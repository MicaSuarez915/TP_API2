package model;

public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	@Column(name="id", nullable=false)
	private int numero;

	public Foto() {
		// TODO Auto-generated constructor stub
	}

}
