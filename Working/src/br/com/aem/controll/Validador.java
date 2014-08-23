package br.com.aem.controll;

/**
 *
 * @author danilo
 */
public class Validador {
    String cpfMask = "[0-9]{3}[\\.]{1}[0-9]{3}[\\.]{1}[0-9]{3}[\\-]{1}[0-9]{2}";
    String ncpf;
    boolean rules;
    
    public boolean validarCpf(String cpf){
        if(cpf.matches(cpfMask) && !isInvalid(cpf)){
            ncpf = cpf.replace(".", "").replace("-", "");
            return rules = verifica(ncpf)?true:false;
        }else return false;
    }
    
    private boolean isInvalid(String cpf) {
        char i = cpf.charAt(0);
        return cpf.equals(""+i+""+i+""+i+"."+i+""+i+""+i+"."+i+""+i+""+i+"-"+i+""+i);
    }
    
    private int[] converte(String ncpf){
        int[] valores = new int[ncpf.length()];
        for(int i = 0; i < ncpf.length(); i++){
            valores[i] = ncpf.charAt(i) - '0';
        }   
        return valores;
    }
    
    private boolean verifica(String ncpf){
        int[] arrayNum = converte(ncpf.substring(0,9));
        int[] arrayNum2 = converte(ncpf.substring(0,10));
        int dg1 = calcDig(arrayNum, 10);
        int dg2 = calcDig(arrayNum2, 11);
        return ncpf.matches(ncpf.substring(0,9)+dg1+dg2);
    } 
    
    private int calcDig(int[] arrayNum, int peso){
        int soma = 0;
        for(int i = 0; i < arrayNum.length; i++){
            soma += (arrayNum[i] * peso--);
        }
        int resto = (soma % 11);
        return (resto < 2)? 0:(11 - resto);
    }
}
