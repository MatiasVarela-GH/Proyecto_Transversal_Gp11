
package entidades;

public class Inscripcion {
    
    private int idCursada;
    private int idAlumno;
    private int idMateria;
    private float nota;
    private float asistencia;
    private int cursa;

    public Inscripcion(int idCursada, int idAlumno, int idMateria, float nota, float asistencia, int cursa) {
        this.idCursada = idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
        this.asistencia = asistencia;
        this.cursa = cursa;
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

    public int getCursa() {
        return cursa;
    }

    public void setCursa(int cursa) {
        this.cursa = cursa;
    }
    
    
    
    @Override
    public String toString(){
        return "ID de la cursada:" + idCursada + " " + "ID de la materia: " + idMateria + " " + "Nota de la materia: " + nota + " " + "Asistencias registradas: " + asistencia;
        
    }
    
}
