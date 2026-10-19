
package entidades;

public class Inscripcion {
    
    private int idCursada;
    private int idAlumno;
    private int idMateria;
    private int cuatrimestre;
    private float nota;
    private float asistencia;
    private int anioCursada;
    private boolean estado;

    public Inscripcion(int idCursada, int idAlumno, int idMateria, int cuatrimestre, float nota, float asistencia, int anioCursada, boolean estado){
        this.idCursada= idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.cuatrimestre = cuatrimestre;
        this.nota = nota;
        this.asistencia = asistencia;
        this.anioCursada = anioCursada;
    }

    public Inscripcion(int idAlumno, int idMateria, int cuatrimestre, float nota, float asistencia, int anioCursada, boolean estado) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.cuatrimestre = cuatrimestre;
        this.nota = nota;
        this.asistencia = asistencia;
        this.anioCursada = anioCursada;
    }

    public Inscripcion() {
    }
    

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
    

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(float asistencia) {
        this.asistencia = asistencia;
    }

    public int getAnioCursada() {
        return anioCursada;
    }

    public void setAnioCursada(int anioCursada) {
        this.anioCursada = anioCursada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
   @Override
public String toString() {
    return "ID de la cursada: " + idCursada
            + " ID de la materia: " + idMateria
            + " Año de cursada: " + anioCursada
            + " Nota: " + nota
            + " Asistencias registradas: " + asistencia;
}
    
}
