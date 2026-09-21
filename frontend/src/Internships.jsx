import { useEffect, useState } from "react";

function Internships() {
  const [internships, setInternships] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/api/internships")
      .then((response) => response.json())
      .then((data) => {
        setInternships(data.data || data);
        setLoading(false);
      })
      .catch(() => {
        alert("Unable to load internships.");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <h2>Loading internships...</h2>;
  }

  return (
    <div className="internship-page">
      <h2>Available Internships</h2>

      <div className="internship-grid">
        {internships.length === 0 ? (
          <p>No internships available.</p>
        ) : (
          internships.map((internship) => (
            <div className="internship-card" key={internship.id}>
              <h3>{internship.title}</h3>

              <p>
                <strong>Company:</strong> {internship.companyName}
              </p>

              <p>
                <strong>Description:</strong> {internship.description}
              </p>

              <p>
                <strong>Location:</strong> {internship.location}
              </p>

              <button>View Details</button>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

export default Internships;