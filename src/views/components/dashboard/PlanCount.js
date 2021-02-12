
const PlanCount = {
  
    render:  () => {
        let view = `

           ${html}
           
        `;

        return view
    },

    after_render:  () => {

    }


}

let html = 
`  <div>
<div>
  <input type="text" for="tipoDeConta">
  <select name="" id="tipoDeConta">
    <option value="Debito">Debito</option>
    <option value="Credito">Credito</option>
    <option value="Poupanca">Poupanca</option>
    <input type="submit" value="Cadastrar">
  </select>
</div>
</div>

<div>
    <div>
        <h1>PLanos já cadastrados</h1>
    </div>
</div>
`
  
   

export default PlanCount;