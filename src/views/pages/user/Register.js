import { footer as Footer } from '../../components/index';

let Register = {
    render: async () => {
        let view = `
            <h1>Here is Register page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Register;