import { footer as Footer } from '../../components/index';

let Home = {
    render: async () => {
        let view = `
            <h1>Here is Home page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Home;