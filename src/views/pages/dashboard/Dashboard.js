import { footer as Footer } from '../../components/index';

let Dashboard = {
    render: async () => {
        let view = `
            <h1>Here is Dashboard page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Dashboard;