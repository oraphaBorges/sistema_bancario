import { dashboardHeader as Header } from '../index';

const AccountPlan = {
    render: () => {
        const PLANOS_CONTA = JSON.parse(localStorage.getItem('PLANOS_CONTA'));  
        const plans = PLANOS_CONTA.map(plan => `<li class="m-1">${ plan }</li>`).join('');
        let view = `
        <div class="content-default content-flex content-justify">
            <div class="section">
            ${ Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vin!') }
            </div>
         </div>
         ${ newAccountPlan(plans) }           
        `;

        return view
    },

    after_render: () => {
        Header.after_render();
    }


}

let newAccountPlan = (plans) =>
`
<div class="content content-default content-flex content-justify">
    <div class="card ">
        <h2>Cadastre um novo plano</h2>
        <form id="login_form" class="card-form">
            <input type="text" placeholder="Digite novo plano">            
            <button id="button_submit" type="submit" class="btn btn-main-outline btn-rounded">Cadastrar</button>
        </form>   
        <div>
            <div class="content-align--center">
                <span class="text-size--20 text-weight--bold text-grey">Planos cadastrados</span>                
            </div>
            <div>
                <ul class="text-card--default">
                    ${ plans }
                </ul>
            </div>        
        </div>     
    </div>
</div>
`


export default AccountPlan;