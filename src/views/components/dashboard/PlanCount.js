import { dashboardHeader as Header, card as Card} from '../index';

const PlanCount = {
  
    render:  () => {
        let view = `
        <div class="content-default content-flex content-justify">
            <div class="section">
            ${ Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vin!') }
            </div>
         </div>
         ${newAcountPlan}           
        `;

        return view
    },

    after_render:  () => {

    }


}

let newAcountPlan = 
`
<div class="content content-default content-flex content-justify">
    <div class="card ">
        <h2>Cadastre novo plano</h2>
        <form id="login_form" class="card-form mt-5">
            <input  type="text" placeholder="Digite novo plano">            
            <button id="button_submit " type="submit" class="btn btn-main-outline btn-rounded">Cadastrar</button>
        </form>            
    </div> 
    <div class="card ">
        <h2>Planos Cadastrados</h2>
        <form id="login_form" class="card-form ">
            <ul class="text-card--default text-center card-list--none padding--dault">
                <li>Academia</li>
                <li>Imposto</li>
                <li>Compra</li>
                <li>IPVA</li>
                <li>IPTU</li>
                <li>Declaração Imposto</li>
                <li>Escola</li>
                <li>Viagens</li>
            </ul>
        </form>            
    </div>  
    
</div>



`


export default PlanCount;