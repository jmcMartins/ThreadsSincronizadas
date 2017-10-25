package iftm.so;

public class Aluno 
{
	private String nome;
	private int ra;
	private int nInscricao;
	
	public Aluno() {}
	
	public Aluno(String _nome, int _ra, int _nInscricao) 
	{
		this.nome = _nome;
		this.ra = _ra;
		this.nInscricao = _nInscricao;
	}
	
	@Override
	public String toString() 
	{
		return String.format(" Nome: %10s | R.A.: %3d | Nº Incrição: %3d \n", this.nome,this.ra,this.nInscricao);
	}
	
}
