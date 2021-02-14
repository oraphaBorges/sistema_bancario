import DashboardService from '../../../service/DashboardService';
import { dashboardHeader as Header } from '../index';

const AccountPlan = {
    render: () => {
        const PLANOS_CONTA = JSON.parse(localStorage.getItem('PLANOS_CONTA'));  
        const plans = PLANOS_CONTA.map(plan => `<li class="m-1">${ plan }</li>`).join('');
        const NOME_USUARIO = 'nome usuario';
        let view = `
        <div class="content-default content-flex content-justify">
          <div class="dash-header">
              <div class="section">
                ${ Header.render(`Olá, <strong id="user-name">${NOME_USUARIO}</strong>, seja bem-vind!`, 'accountplan') }
              </div>
          </div>
         </div>
         ${ newAccountPlan(plans) }           
        `;

        return view
    },

    after_render: () => {
        Header.after_render();
        const account_form = document.getElementById('login_form');
        account_form.addEventListener('submit', async e => {
            e.preventDefault();
            
            const finalidade = document.getElementById('finalidade').value;
            const data = { finalidade: finalidade }

            await DashboardService.setAccountPlan(data);           
        })
    }
}

let newAccountPlan = (plans) =>
`
<div class="content content-default content-flex content-justify">
    <div class="card ">
        <h2>Cadastre um novo plano</h2>
        <form id="login_form" class="card-form">
            <input id="finalidade" type="text" placeholder="Digite novo plano" required>            
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