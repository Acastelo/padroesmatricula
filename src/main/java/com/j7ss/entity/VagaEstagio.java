package com.j7ss.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.j7ss.entity.constraint.VagaEstagioStatus;
import com.j7ss.entity.constraint.VagaEstagioTurno;
import com.j7ss.entity.constraint.VagaEstagioType;

@Entity
@Table(name = "vaga_estagio")
public class VagaEstagio extends BaseEntity<Integer>{
	
	private String nome;
	
	private String descricao;
	
	private String requisitos;
	
	private String atividades;   // Atividades a serem desenvolvidas
	
	private String resultados;   // Resultados esperados
	
	private String setor;   	// Setor de realização do estagio
	
	private String beneficios;
	
	private Integer cargaHoraria;
	
	private Double remuneracao;
	
	private VagaEstagioTurno turno;
	
	private Date horaInicioEstagio;
	
	private Date horaFimOuIntervalo;
	
	private Date horaRetorno;
	
	private Date horaFimEstagio;
	
	private Date vigenciaInicio;
	
	private Date vigenciaFim;
	
	private Double valorTransporte;
	
    private String apoliceNumero;
	
	private String apoliceEmpresa;
	
	private VagaEstagioStatus status = VagaEstagioStatus.NOVA;
	
	private VagaEstagioType type = VagaEstagioType.OBRIGATORIO;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private EmpresaSupervisor empresaSupervisor;
	
	@OneToMany(mappedBy="vagaEstagio", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.SUBSELECT)  
	@OrderBy("date")
	private List<VagaEstagioAtividadeDiaria> atividadesDiaria;
	
	@OneToMany(mappedBy="vagaEstagio", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(FetchMode.SUBSELECT)  
	@OrderBy("ordem")
	private List<DocumentoVagaEstagio> documentosVagaEstagio;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Double remuneracao) {
		this.remuneracao = remuneracao;
	}

	public VagaEstagioTurno getTurno() {
		return turno;
	}

	public void setTurno(VagaEstagioTurno turno) {
		this.turno = turno;
	}

	public Date getHoraInicioEstagio() {
		return horaInicioEstagio;
	}

	public void setHoraInicioEstagio(Date horaInicioEstagio) {
		this.horaInicioEstagio = horaInicioEstagio;
	}

	public Date getHoraFimOuIntervalo() {
		return horaFimOuIntervalo;
	}

	public void setHoraFimOuIntervalo(Date horaFimOuIntervalo) {
		this.horaFimOuIntervalo = horaFimOuIntervalo;
	}

	public Date getHoraRetorno() {
		return horaRetorno;
	}

	public void setHoraRetorno(Date horaRetorno) {
		this.horaRetorno = horaRetorno;
	}

	public Date getHoraFimEstagio() {
		return horaFimEstagio;
	}

	public void setHoraFimEstagio(Date horaFimEstagio) {
		this.horaFimEstagio = horaFimEstagio;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public Double getValorTransporte() {
		return valorTransporte;
	}

	public void setValorTransporte(Double valorTransporte) {
		this.valorTransporte = valorTransporte;
	}

	public String getApoliceNumero() {
		return apoliceNumero;
	}

	public void setApoliceNumero(String apoliceNumero) {
		this.apoliceNumero = apoliceNumero;
	}

	public String getApoliceEmpresa() {
		return apoliceEmpresa;
	}

	public void setApoliceEmpresa(String apoliceEmpresa) {
		this.apoliceEmpresa = apoliceEmpresa;
	}

	public VagaEstagioStatus getStatus() {
		return status;
	}

	public void setStatus(VagaEstagioStatus status) {
		this.status = status;
	}

	public VagaEstagioType getType() {
		return type;
	}

	public void setType(VagaEstagioType type) {
		this.type = type;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setEmpresaSupervisor(EmpresaSupervisor empresaSupervisor) {
		this.empresaSupervisor = empresaSupervisor;
	}

	public void setAtividadesDiaria(List<VagaEstagioAtividadeDiaria> atividadesDiaria) {
		this.atividadesDiaria = atividadesDiaria;
	}

	public void setDocumentosVagaEstagio(List<DocumentoVagaEstagio> documentosVagaEstagio) {
		this.documentosVagaEstagio = documentosVagaEstagio;
	}

	public VagaEstagio(){ }
	
	public VagaEstagio(String nome){
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public EmpresaSupervisor getEmpresaSupervisor() {
		return empresaSupervisor;
	}

	public List<VagaEstagioAtividadeDiaria> getAtividadesDiaria() {
		return atividadesDiaria;
	}

	public List<DocumentoVagaEstagio> getDocumentosVagaEstagio() {
		return documentosVagaEstagio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
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
		VagaEstagio other = (VagaEstagio) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VagaEstagio [nome=" + nome + ", descricao=" + descricao + ", requisitos=" + requisitos + ", atividades="
				+ atividades + ", resultados=" + resultados + ", setor=" + setor + ", beneficios=" + beneficios
				+ ", cargaHoraria=" + cargaHoraria + ", remuneracao=" + remuneracao + ", turno=" + turno
				+ ", horaInicioEstagio=" + horaInicioEstagio + ", horaFimOuIntervalo=" + horaFimOuIntervalo
				+ ", horaRetorno=" + horaRetorno + ", horaFimEstagio=" + horaFimEstagio + ", vigenciaInicio="
				+ vigenciaInicio + ", vigenciaFim=" + vigenciaFim + ", valorTransporte=" + valorTransporte
				+ ", apoliceNumero=" + apoliceNumero + ", apoliceEmpresa=" + apoliceEmpresa + ", status=" + status
				+ ", type=" + type + ", aluno=" + aluno + ", empresa=" + empresa + ", empresaSupervisor="
				+ empresaSupervisor + ", atividadesDiaria=" + atividadesDiaria + ", documentosVagaEstagio="
				+ documentosVagaEstagio + "]";
	}

		
}
